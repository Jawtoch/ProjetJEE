package servlet;

import bean.UserBean;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.*;
import java.util.List;

@WebServlet(name = "UploadImageServlet")
public class UploadImageServlet extends HttpServlet {

    private static final long serialVersionUID = 1273074928096412095L;


    public static final String IMAGES_FOLDER = "images";
    public static final int BUFF_SIZE = 10240;


    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UserBean current_user = (UserBean) session.getAttribute("current_user");

        response.sendRedirect("account.jsp");

    }
       /* if (!ServletFileUpload.isMultipartContent(request)) {
            //Pas de fichier, redirection
            response.sendRedirect("account.jsp");
        }

        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        //temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
        ServletFileUpload upload = new ServletFileUpload(factory);

        //maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
        //maximum size of request
        upload.setSizeMax(MAX_REQUEST_SIZE);

        // constructs the directory path
        // this path is relative to application's directory
        String uploadPath = getServletContext().getRealPath("") + File.separator + IMAGES_FOLDER;

        try {
            // parses the request's content to extract file data
            List<FileItem> formItems = upload.parseRequest(request);

            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        String fileName = Integer.toString(current_user.getId());
                        String filePath = uploadPath + File.separator + fileName;
                        File storeFile = new File(filePath);

                        //upload image
                        item.write(storeFile);
                    }
                }
            }
        } catch (Exception e) {
           e.printStackTrace();
        }


    }

    private void ecrireFichier(Part part, String nomFichier) throws IOException {
        BufferedInputStream entree = null;
        BufferedOutputStream sortie = null;
        try {
            entree = new BufferedInputStream(part.getInputStream(), BUFF_SIZE);
            sortie = new BufferedOutputStream(new FileOutputStream(new File(UploadImageServlet.IMAGES_FOLDER + nomFichier)), BUFF_SIZE);

            byte[] tampon = new byte[BUFF_SIZE];
            int longueur;
            while ((longueur = entree.read(tampon)) > 0) {
                sortie.write(tampon, 0, longueur);
            }
        } finally {
            try {
                sortie.close();
            } catch (IOException ignore) {
            }
            try {
                entree.close();
            } catch (IOException ignore) {
            }
        }
    }

    private static String getNomFichier( Part part ) {
        for ( String contentDisposition : part.getHeader( "content-disposition" ).split( ";" ) ) {
            if ( contentDisposition.trim().startsWith( "filename" ) ) {
                return contentDisposition.substring( contentDisposition.indexOf( '=' ) + 1 ).trim().replace( "\"", "" );
            }
        }
        return null;
    }


        */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
