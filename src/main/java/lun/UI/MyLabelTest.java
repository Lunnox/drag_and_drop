package lun.UI;

import com.vaadin.data.Binder;
import com.vaadin.shared.ui.dnd.EffectAllowed;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.dnd.DragSourceExtension;
import lun.Data.Task;
import lun.Data.statusType;

public class MyLabelTest extends Label {



    private Task currentTask;


    public MyLabelTest(Task task) {
        super(task.getHeader());
        currentTask=task;

        initDrag();
        /*Binder<Task> binder = new Binder<>(Task.class);
        binder.bindInstanceFields(this);
        binder.setBean(task);
*/
    }

    private void initDrag(){
        DragSourceExtension<MyLabelTest> dragSource = new DragSourceExtension<>(this);
        dragSource.setEffectAllowed(EffectAllowed.MOVE);
        dragSource.setDataTransferText("hello receiver");
        dragSource.addDragStartListener(event ->
                Notification.show("Drag event started")
        );
        dragSource.addDragEndListener(event -> {
            if (event.isCanceled()) {
                Notification.show("Drag event was canceled");
            } else {
                Notification.show("Drag event finished");
                System.out.println(currentTask.getStatus());
            }
        });


        /*
        dragSource.addDragStartListener(event ->
                dragSource.setDragData(root)
        );
        dragSource.addDragEndListener(event ->
                dragSource.setDragData(null)
        );
        */
    }

    public statusType getType() {
        return currentTask.getStatus();
    }

    public void setType(statusType type) {
        this.currentTask.setStatus(type.name().toLowerCase());
    }


}
