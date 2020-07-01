package com.perfree.controller;

import com.perfree.mapper.AttachMapper;
import com.perfree.service.AttachService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Api(tags = "上传文件处理接口")
@RestController
@CrossOrigin
@RequestMapping("/upload")
public class UploadController extends BaseController {
    @Value("${upload.imgPath}")
    private String uploadImgPath;

    @Autowired
    private AttachService attachService;

    @PostMapping(value = "/img")
    public Map<String, String> imgUpload(@RequestParam(value = "file") MultipartFile file) {
        // 获取文件名称
        String fileName = file.getOriginalFilename();
        // 获取扩展名
        String fileExtensionName = fileName.substring(fileName.lastIndexOf(".") + 1);
        // 获取文件名
        String name = fileName.substring(0, fileName.lastIndexOf("."));
        // 生成最终保存的文件名,格式为: 时间戳-文件名.扩展名
        String uid = String.valueOf(new Date().getTime());
        String saveFileName = uid + "-" + name + "." + fileExtensionName;
        File fileDir = new File(uploadImgPath);
        if (!fileDir.exists()){
            fileDir.setWritable(true);
            fileDir.mkdirs();
        }
        File targetFile = new File(uploadImgPath, saveFileName);
        try {
            file.transferTo(targetFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String filePath = String.format("/img/%s", saveFileName);
        Long id = attachService.saveFile(saveFileName, filePath, 1);
        Map<String, String> result = new HashMap<>();
        result.put("url", filePath);
        result.put("uid", uid);
        result.put("fileName", saveFileName);
        result.put("filePath", filePath);
        result.put("id", id.toString());
        result.put("name", file.getName());
        return result;
    }
}
