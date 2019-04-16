package top.axbt.keshe.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.axbt.entity.Result;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * Create by 张晨彬
 * 2018/12/22/022 8:37
 */


@RestController
public class UploadController {


    @RequestMapping("/upload")
    public Result upload(HttpServletRequest req, MultipartFile file){
        try{
            //2.根据时间戳创建新的文件名，这样即便是第二次上传相同名称的文件，也不会把第一次的文件覆盖了
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            //3.通过req.getServletContext().getRealPath("") 获取当前项目的真实路径，然后拼接前面的文件名
            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            //4.第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录（创建到了webapp下uploaded文件夹下）
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            //5.把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            return new Result(true,fileName);
        }catch (Exception e){
            return new Result(true,"上传失败");
        }

    }

}
