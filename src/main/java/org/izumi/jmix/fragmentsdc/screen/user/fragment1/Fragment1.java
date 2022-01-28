package org.izumi.jmix.fragmentsdc.screen.user.fragment1;

import io.jmix.ui.model.DataLoader;
import io.jmix.ui.model.InstanceContainer;
import io.jmix.ui.screen.Screen;
import io.jmix.ui.screen.ScreenFragment;
import io.jmix.ui.screen.Subscribe;
import io.jmix.ui.screen.Target;
import io.jmix.ui.screen.UiController;
import io.jmix.ui.screen.UiDescriptor;
import org.izumi.jmix.fragmentsdc.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

@UiController("Fragment1")
@UiDescriptor("fragment-1.xml")
public class Fragment1 extends ScreenFragment {
    private static final Logger log = LoggerFactory.getLogger(Fragment1.class);

    @Autowired
    private DataLoader userDl;

    @Autowired
    private InstanceContainer<User> userDc;

    @Subscribe(target = Target.PARENT_CONTROLLER)
    private void onBeforeShow(Screen.BeforeShowEvent event) {
        userDl.load();
        User user = userDc.getItemOrNull();
        if (user == null) {
            log.warn("User is null");
        } else {
            log.warn("Everything is ok with user");
        }
    }
}
