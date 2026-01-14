package net.sourceforge.MSGViewer;

import java.io.BufferedReader;

import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Files;

public final class R8 {

public static byte[] readAllBytes(java.io.InputStream in) throws java.io.IOException {
    byte[] buffer = new byte[8192]; int n;
    java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
    while ((n = in.read(buffer)) != -1) {
        baos.write(buffer, 0, n);
    }
    return baos.toByteArray();
}

public static String repeat(String str, int count) {
    if (str == null) { return null; }
    if (count <= 0) { return ""; }
    StringBuilder sb = new StringBuilder(str.length() * count);
    for (int i = 0; i < count; i++) { sb.append(str); }
    return sb.toString();
}

public static String readString(Path path) throws java.io.IOException {
    return readString(path,  java.nio.charset.StandardCharsets.UTF_8);
}

public static String readString(Path path, Charset cs) throws java.io.IOException {
    StringBuilder sb = new StringBuilder(8192);
    try (BufferedReader br = Files.newBufferedReader(path, cs)) {
        String line;
        String nl = System.lineSeparator();
        while ((line = br.readLine()) != null) {
            sb.append(line).append(nl);
        }
    }
    return sb.toString();
}

}