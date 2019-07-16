package lun.Data;

import lun.Data.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

public interface TaskRepository extends JpaRepository<Task, Long>{
    @Transactional
    void deleteByDone(boolean done);

    int countByDone(boolean done);


}
