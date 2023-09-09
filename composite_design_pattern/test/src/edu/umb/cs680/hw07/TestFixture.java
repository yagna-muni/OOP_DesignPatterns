package edu.umb.cs680.hw07;

import java.time.LocalDateTime;

public class TestFixture {
    public static FileSystem provisionFileSystem() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        fileSystem.clearRootDir();

        Directory root = new Directory(null, "root", 0, LocalDateTime.now());
        Directory Apps = new Directory(null, "Apps", 0, LocalDateTime.now());
        Directory lib = new Directory(root, "lib", 0, LocalDateTime.now());
        Directory home = new Directory(root, "home", 0, LocalDateTime.now());

        File x = new File(Apps, "x", 25, LocalDateTime.now());
        File y = new File(Apps, "y", 20, LocalDateTime.now());
        File z = new File(lib, "z", 400, LocalDateTime.now());

        Directory code = new Directory(home, "code", 0, LocalDateTime.now());

        File d = new File(home, "d", 300, LocalDateTime.now());

        File a = new File(code, "a", 7, LocalDateTime.now());
        File b = new File(code, "b", 9, LocalDateTime.now());
        File c = new File(code, "c", 4, LocalDateTime.now());

        fileSystem.appendRootDir(root);
        root.appendChild(Apps);
        root.appendChild(lib);
        root.appendChild(home);
        Apps.appendChild(x);
        Apps.appendChild(y);
        lib.appendChild(z);
        home.appendChild(code);
        home.appendChild(d);
        code.appendChild(a);
        code.appendChild(b);
        code.appendChild(c);

        return fileSystem;
    }
}
