//package org.o7planning.hellospringboot.controller;
//
//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.nio.file.Paths;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//@Controller
//@RequestMapping("/downloadAction")
//public class FileController {
//
//    @RequestMapping(value="downloadAction/pdf/{fileName:.+}", method = RequestMethod.GET)
//    public void downloadPDFResource( HttpServletRequest request,
//                                     HttpServletResponse response,
//                                     @PathVariable("fileName") String fileName)
//    {
//        //If user is not authorized - he should be thrown out from here itself
//         
//        //Authorized user will download the file
//        String dataDirectory = request.getServletContext().getRealPath("/download/pdf/");
//        System.out.println("directory : "+dataDirectory);
//        Path file = Paths.get(dataDirectory, fileName);
//        if (Files.exists(file))
//        {
//            response.setContentType("application/pdf");
//            response.addHeader("Content-Disposition", "attachment; filename="+fileName);
//            try
//            {
//                Files.copy(file, response.getOutputStream());
//                response.getOutputStream().flush();
//            }
//            catch (IOException ex) {
//                ex.printStackTrace();
//            }
//        }
//        else {
//        	System.out.println("le fichier n'existe pas");
//        }
//    }
//}