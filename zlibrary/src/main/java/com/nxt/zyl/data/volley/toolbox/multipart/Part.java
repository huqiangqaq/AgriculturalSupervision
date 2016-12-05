package com.nxt.zyl.data.volley.toolbox.multipart;

import java.io.IOException;
import java.io.OutputStream;

/**
 * @author <a href="mailto:vit at cleverua.com">Vitaliy Khudenko</a>
 */
public interface Part {
      long getContentLength(Boundary boundary);
      void writeTo(final OutputStream out, Boundary boundary) throws IOException;
}
