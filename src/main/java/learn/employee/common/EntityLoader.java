package learn.employee.common;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.support.Repositories;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EntityLoader {

    private final Repositories repositories;

    public EntityLoader(ApplicationContext applicationContext) {
        this.repositories = new Repositories(applicationContext);
    }

    /**
     * Loads an entity by ID using the correct repository.
     * Returns null if id is null.
     * Throws exception if entity not found.
     */
    @SuppressWarnings("unchecked")
    public <T, ID> T load(Class<T> entityClass, ID id) {
        if (id == null) {
            return null;
        }
        // Get the repository for this entity type
        Optional<Object> repoOpt = repositories.getRepositoryFor(entityClass);

        if (repoOpt.isEmpty()) {
            throw new IllegalStateException("No repository found for entity: " + entityClass.getSimpleName());
        }

        JpaRepository<T, ID> repo = (JpaRepository<T, ID>) repoOpt.get();

        // Find entity or throw
        return repo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(
                        entityClass.getSimpleName() + " not found with id: " + id));
    }
}