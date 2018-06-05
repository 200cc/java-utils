package me.cc200.utils;

import lombok.Cleanup;
import lombok.SneakyThrows;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

public class HttpUtil {

    public static final Charset UTF8 = Charset.forName("utf-8");

    public static final Charset ISO88591 = Charset.forName("iso-8859-1");

    private HttpUtil() {}

    @SneakyThrows
    public static void responseFileStream(HttpServletResponse response, File file, String filename) {
        filename = StringUtil.isEmpty(filename) ? file.getName() : filename;

        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes(UTF8), ISO88591));

        @Cleanup InputStream is = new FileInputStream(file);
        @Cleanup OutputStream os = response.getOutputStream();
        byte[] buffer = new byte[1024];
        int len;
        while ((len = is.read(buffer, 0, buffer.length)) != -1) {
            os.write(buffer, 0, len);
        }
        os.flush();
    }
}
