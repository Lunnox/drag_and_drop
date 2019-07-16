package lun.UI;

import com.vaadin.event.ShortcutAction;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.server.VaadinRequest;

import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.*;

import com.vaadin.ui.themes.ValoTheme;
import lun.Data.Task;
import lun.Data.statusType;
import org.springframework.beans.factory.annotation.Autowired;


@SpringUI
public class drag_and_drop_ui extends UI {

    private VerticalLayout root;

    @Autowired
    PanelTaskList panelTypeNew;//= new VerticalLayout();
    @Autowired
    PanelTaskList panelTypeProgress;
    @Autowired
    PanelTaskList panelTypeDone;




    @Override
    protected void init(VaadinRequest vaadinRequest) {
        setupLayout();
        addHeader();
        addForm();

    }

    private void setupLayout() {
        root = new VerticalLayout();
        root.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setContent(root);
    }

    private void addHeader() {
        Label header = new Label("TODO");
        header.addStyleName(ValoTheme.LABEL_H1);
        root.addComponent(header);
    }




    private void addForm() {
        panelTypeNew.addStyleName(ValoTheme.LAYOUT_CARD);
        panelTypeNew.setStatusType(statusType.neww.name());
        panelTypeNew.setCaption(panelTypeNew.getStatusType());

        panelTypeProgress.addStyleName(ValoTheme.LAYOUT_CARD);
        panelTypeProgress.setStatusType(statusType.inprogress.name());
        panelTypeProgress.setCaption(panelTypeProgress.getStatusType());

        panelTypeDone.addStyleName(ValoTheme.LAYOUT_CARD);
        panelTypeDone.setStatusType(statusType.done.name());
        panelTypeDone.setCaption(panelTypeDone.getStatusType());

        panelTypeProgress.update();
        panelTypeDone.update();
        panelTypeNew.update();





        HorizontalLayout formLayout = new HorizontalLayout();
        formLayout.setWidth("80%");
        HorizontalLayout panelTasks = new HorizontalLayout();
        panelTasks.setWidth("80%");
        panelTasks.setHeight("80%");
        TextField task = new TextField();
        Button add = new Button("");
        add.addStyleName(ValoTheme.BUTTON_PRIMARY);
        add.setIcon(VaadinIcons.PLUS);
        formLayout.addComponentsAndExpand(task);
        formLayout.addComponents(add);
        task.focus();
        panelTasks.addComponent(panelTypeNew);
        panelTasks.addComponent(panelTypeProgress);
        panelTasks.addComponent(panelTypeDone);
        root.addComponent(formLayout);
        root.addComponent(panelTasks);
        add.addClickListener(click -> {
            Task newTask = new Task(task.getValue());
            newTask.setDone(statusType.neww.name());

            panelTypeNew.add(newTask);
            task.clear();
            task.focus();
        });
        add.setClickShortcut(ShortcutAction.KeyCode.ENTER);

    }



}
