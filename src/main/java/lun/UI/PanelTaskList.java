package lun.UI;

import com.vaadin.shared.ui.dnd.DropEffect;
import com.vaadin.spring.annotation.SpringComponent;
import com.vaadin.ui.AbstractComponent;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.dnd.DropTargetExtension;
import lun.Data.Task;
import lun.Data.statusType;
import lun.Data.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringComponent
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PanelTaskList extends VerticalLayout {

    private String statusType;

    @Autowired
    private TaskRepository repository;




    @PostConstruct
    void init() {
       // update();
        initDropAction();
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public String getStatusType() {
        return statusType;
    }


    public void add(Task newObject) {
        repository.save(newObject);
        update();
        //addComponent(new MyLabelTest(newObject));
    }


    public void update() {
        setTodos(repository.findAll());
    }

    private void setTodos(List<Task> all) {
        removeAllComponents();
        all.forEach(task ->{
            MyLabelTest item= new MyLabelTest(task);
            System.out.println(task.isDone() + " "+this.statusType);
            if (task.isDone().equals(this.statusType)) {
                addComponent(item);
            }
        });




    }

    private void initDropAction() {

        DropTargetExtension<PanelTaskList> dropTarget = new DropTargetExtension<>(this);
        dropTarget.setDropEffect(DropEffect.MOVE);
        dropTarget.addDropListener(event -> {
            Optional<AbstractComponent> dragSource = event.getDragSourceComponent();
            if (dragSource.isPresent() && dragSource.get() instanceof Label) {
                MyLabelTest object= (MyLabelTest) dragSource.get();
                this.addComponent(object);
                object.setType(this.statusType);
                
                String message = String.valueOf(event.getDataTransferData("text/html"));
                if (message != null) {
                    Notification.show("DropEvent with data transfer html: " + message);
                } else {
                    message = event.getDataTransferText();
                    Notification.show("DropEvent with data transfer text: " + message);
                }
            }
        });
    }





}
