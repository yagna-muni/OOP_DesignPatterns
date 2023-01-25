package edu.umb.cs680.hw03;

public class Single {
    private Single() { };
    private static Single instance=null;

    public static Single getInstance() {
            if (instance == null)
                instance = new Single();
            return instance;
        }

    public static void main(String[] args) {
        Single madgud1= new Single();
        Single madgud2= new Single();
    }
}

