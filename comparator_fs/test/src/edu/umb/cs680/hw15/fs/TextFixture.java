package edu.umb.cs680.hw15.fs;

import java.time.LocalDateTime;

public class TextFixture {
    public static FileSystem provisionFileSystem() {
        FileSystem fileSystem = FileSystem.getFileSystem();
        fileSystem.clearRootDir();

        Directory root = new Directory(null, "root", 0, LocalDateTime.of(2020, 11,11,11,00,00));
        Directory Apps = new Directory(null, "Apps", 0, LocalDateTime.of(2020, 12,01,12,00,40));
        Directory bin = new Directory(root, "bin", 0, LocalDateTime.of(2022, 12,01,12,00,00));
        Directory home = new Directory(root, "home", 0, LocalDateTime.of(2022, 12,01,12,10,00));

        File x = new File(Apps, "x", 25, LocalDateTime.now());
        File y = new File(bin, "y", 20, LocalDateTime.now());
        Directory pictures = new Directory(home, "pictures", 0, LocalDateTime.now());
        File c = new File(home, "c", 4, LocalDateTime.now());

        File a = new File(pictures, "a", 7, LocalDateTime.now());
        File b = new File(pictures, "b", 9, LocalDateTime.now());
        File a_b = new File(pictures, "c", 10, LocalDateTime.now());

        Link dLink = new Link(root, "d", 0, LocalDateTime.of(2022, 12,01,12,10,45), pictures);
        Link eLink = new Link(root, "e",0, LocalDateTime.of(2022, 12,01,16,10,00),x);


        fileSystem.appendRootDir(root);
        root.appendChild(Apps);
        root.appendChild(bin);
        root.appendChild(home);
        root.appendChild(dLink);
        root.appendChild(eLink);
        Apps.appendChild(x);
        bin.appendChild(y);
        home.appendChild(pictures);
        home.appendChild(c);
        pictures.appendChild(a);
        pictures.appendChild(b);
        pictures.appendChild(a_b);

        return fileSystem;
    }
}

