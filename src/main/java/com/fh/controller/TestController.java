package com.fh.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/projectFile")
public class TestController {

        // 处理文件上传
        @PostMapping("/upload")

        public String projectFileUpload(HttpServletRequest request,
                                        @RequestParam("file") MultipartFile file) throws IllegalStateException, IOException {

            if(!file.isEmpty()) {
                //上传文件路径
                String path = request.getServletContext().getRealPath("/images/");
                //上传文件名
                String filename = file.getOriginalFilename();
                File filepath = new File(path,filename);
                //判断路径是否存在，如果不存在就创建一个
                if (!filepath.getParentFile().exists()) {
                    filepath.getParentFile().mkdirs();
                }
                //将上传文件保存到一个目标文件当中
                file.transferTo(new File(path + File.separator + filename));
                return "success";
            } else {
                return "error";
            }

        }


        // 设置上下方文
/*        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
                request.getSession().getServletContext());

        // 检查form是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
            MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;

            Iterator<String> iter = multiRequest.getFileNames();
            while (iter.hasNext()) {

                // 由CommonsMultipartFile继承而来,拥有上面的方法.
                MultipartFile file = multiRequest.getFile(iter.next());
                if (file != null) {
                    String fileName = file.getOriginalFilename();
                    String path = "D:/" + fileName;

                    File localFile = new File(path);
                    file.transferTo(localFile);
                }

            }
        }
        return "dataSuccess";


    }

*/
        @GetMapping("/download")
        public ResponseEntity<byte[]> download(HttpServletRequest request,
                                               @RequestParam("filename") String filename,
                                               Model model)throws Exception {
            //下载文件路径
            String path = request.getServletContext().getRealPath("/images/");
            File file = new File(path + File.separator + filename);
            HttpHeaders headers = new HttpHeaders();
            //下载显示的文件名，解决中文名称乱码问题
            String downloadFileName = new String(filename.getBytes("UTF-8"),"iso-8859-1");
            //通知浏览器以attachment（下载方式）打开图片
            headers.setContentDispositionFormData("attachment", downloadFileName);
            //application/octet-stream ： 二进制流数据（最常见的文件下载）。
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                    headers, HttpStatus.CREATED);
        }




        @GetMapping("/test")
        public String test() {
            return "success";
        }
    }
/*    public Map<String, String> uploadFile(MultipartFile txt) throws IOException {
        Map<String, String> result = new HashMap<>();
        try (FileOutputStream fos = new FileOutputStream("./test.txt")) {
            byte[] bytes = txt.getBytes();
            fos.write(bytes);
            fos.flush();
            result.put("status", "success");
        } catch (Exception e) {
            result.put("status", "failed");
        }

        return result;

    }


}
*/


