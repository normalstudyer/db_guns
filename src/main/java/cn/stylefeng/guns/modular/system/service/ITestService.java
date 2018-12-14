package cn.stylefeng.guns.modular.system.service;

import cn.stylefeng.guns.modular.system.model.Test;
import com.baomidou.mybatisplus.service.IService;

import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author stylefeng
 * @since 2018-12-05
 */
public interface ITestService extends IService<Test> {
    /**
     * 上传并处理用户图片
     */
    public String uploadUserImage(String base64Code,int x1,int y1,int x2,int y2) throws IOException;

    public String uploadUserImage1(String base64Code) throws IOException;
}
