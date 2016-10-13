/**
 * MIT License
 *
 * Copyright (c) 2016 Bouw Informatie Raad
 *
 * Permission is hereby granted, free of charge, to any person obtaining
 * a copy of this software and associated documentation files (the "Software"),
 * to deal in the Software without restriction, including without limitation
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL
 * THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS
 * IN THE SOFTWARE.
 *
 **/
package nl.coinsweb.example;


import nl.coinsweb.sdk.jena.JenaCoinsContainer;
import nl.coinsweb.sdk.validator.Validator;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Validate {


  public static void main( String... args ) {
    JenaCoinsContainer model = new JenaCoinsContainer("http://playground.com/");
    model.load(getResourceFile("starterskit4.01_inmem.ccr").getAbsolutePath());


    Path reportFile = Paths.get("/tmp/report_4.01.html");

    Validator validator = new Validator(model, "COINS 2.0 Lite");
    validator.validate(reportFile);
    System.exit(0);
  }






  public static File getResourceFile(String fileName) {
    URI fullPath = null;
    try {
      URL fullPathUrl = Validate.class.getClassLoader().getResource(fileName);
      if(fullPathUrl != null) {
        fullPath = new URI(fullPathUrl.toString());
      }
    } catch (URISyntaxException e) {
      System.out.println("File not found: "+fileName);
    }

    if(fullPath == null) {
      System.out.println("File not found: "+fileName);
    }
    return new File(fullPath);
  }
}
