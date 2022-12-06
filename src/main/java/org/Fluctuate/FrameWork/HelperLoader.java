package org.Fluctuate.FrameWork;

import org.Fluctuate.FrameWork.helper.IocHelper;
import org.Fluctuate.FrameWork.helper.BeanHelper;
import org.Fluctuate.FrameWork.helper.ClassHelper;
import org.Fluctuate.FrameWork.helper.ControllerHelper;
import org.Fluctuate.FrameWork.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
                ClassHelper.class,
                BeanHelper.class,
                IocHelper.class,
                ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName());
        }
    }
}
