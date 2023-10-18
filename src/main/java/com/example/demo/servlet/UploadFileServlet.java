package com.example.demo.servlet;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;

@WebServlet (value = "/upload-file")
@MultipartConfig
public class UploadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        writer.write("<html><body>");
        writer.write("<form action ='upload-file' method='post' enctype='multipart/form-data'>");
        writer.write("File : <input type='file' name='file' multiple />");
        writer.write("<input type='submit' value='submit' />");
        writer.write("</form>");
        writer.write("</body></html>");



    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        Writer writer = resp.getWriter();
        try {
            String outputPath = getServletContext().getRealPath("") + File.separator + "fileUpload";
            File file = new File(outputPath);
            if(!file.exists()){
                file.mkdir();
            }
            Collection<Part> parts = req.getParts();
            for(Part p : parts){
                String fileName = p.getSubmittedFileName();
                p.write(outputPath+ File.separator+fileName);
            }
            writer.write("<html><body>");
            writer.write("upload file thanh cong");
            writer.write("<img src='fileUpload/avatar.png'></img>");
            writer.write("</body></html>");
        } catch (Exception ex){
            log("error upload file"+ex.getMessage());
            writer.write("upload file loi");
        }
    }
}


