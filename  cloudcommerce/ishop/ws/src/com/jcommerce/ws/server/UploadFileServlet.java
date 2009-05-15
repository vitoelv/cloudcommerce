/**
 * root dir：http://localhost:8080/TestProject/
   jsp test：http://localhost:8080/TestProject/TestPath.jsp
   
   result is below:
   request.getContextPath() = /TestProject
   request.getServletPath() = /TestPath.jsp
   request.getRequestURI() = /TestProject/TestPath.jsp
   request.getRequestURL() = http://localhost:8080/TestProject/TestPath.jsp
   request.getRealPath("/") = C:\Tomcat\webapps\TestProject\
 */
package com.jcommerce.ws.server;

import java.io.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItemIterator;
import org.apache.commons.fileupload.FileItemStream;
import org.apache.commons.fileupload.util.Streams;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class UploadFileServlet extends HttpServlet {

	/**
	 * use axis2 default jar (commons-fileupload-1.2.jar)
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.print("receive request...");
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/plain");
        PrintWriter writer = response.getWriter();
        List<String> names = saveUploadFiles(request);
        for (String name : names) {
            writer.write(name+";");
        }
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private List<String> saveUploadFiles(HttpServletRequest request){
		List<String> names = new ArrayList<String>();
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);
		if (isMultipart == true) {
			try {
				FileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				FileItemIterator iter = upload.getItemIterator(request);
				while (iter.hasNext()) {
					FileItemStream item = iter.next();
					String name = item.getFieldName();
					InputStream stream = item.openStream();
					if (item.isFormField()) {
						System.out.print("Form field " + name + " with value " + Streams.asString(stream) + " detected.");
					} else {
						String fileName = new File(item.getName()).getName();						
						System.out.print("Form field " + name + " with file name " + fileName + " detected.");
						Random random = new Random();
						fileName = new Date().getTime() + random.nextInt(1000) + fileName;
						BufferedInputStream bis = new BufferedInputStream(stream);
						String Path = getServletContext().getRealPath("/uploadImages/");
						System.out.println("File Path is :: " + Path);
						BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(new File(Path + "\\" + fileName)));
						Streams.copy(bis, bos, true);
						names.add(fileName);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("the enctype must be multipart/form-data");
		}
		return names;
	}
	
	private String testCreateResponse(HttpServletRequest request, HttpServletResponse response){
		StringBuffer resp = new StringBuffer();
		resp.append("<data jsxid=\"jsxroot\">");
		resp.append("<record jsxid=\"Request Information\">");
		resp.append("<record jsxid=\"Local Address\" jsxtext=\""+request.getLocalAddr()+"\""+"/>");
		resp.append("</record>");
		resp.append("</data>");
		response.setContentType("text/xml");
		return resp.toString();		
	}
}
