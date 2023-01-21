//Отсчет уровня вложенности ведется с 0 (тоесть при нахождении в дирректории dir1, dir2, dir3 level = 0)

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    static int deepestLevelDigit = 0;

    static StringBuilder sb = new StringBuilder();

    static public int deepestLevel(File folder) {
        int currentLevel;
        File[] folderEntries = folder.listFiles();
        for (File entry : folderEntries) {
            currentLevel = countMatches(entry.getPath());
            if (entry.isDirectory()) {
                deepestLevel(entry);
            }
            if (deepestLevelDigit < currentLevel) {
                deepestLevelDigit = currentLevel;
            }
        }
        return deepestLevelDigit - 1;
    }

    private static int countMatches(String path) {
        int number = 0;
        String[] array = path.split("");
        for (int i = 0; i < path.length(); i++) {
            if ("\\".contentEquals(array[i])) {
                number++;
            }
        }
        return number;
    }


    static void RecursivePrint(File[] arr, int index, int level, File dir, List<String> list) {
        //для возвращения к главной рекурсии
        if (index == arr.length)
            return;

        // для файлов
        if (arr[index].isFile() && level == deepestLevel(dir)) {
            sb.append((arr[index].getName()));
            list.add(arr[index].getName());
        }

        // рекурсия для подпапок (на поиск)
        else if (arr[index].isDirectory() && level == deepestLevel(dir)) {
            sb.append(arr[index].getName());
            list.add("[" + arr[index].getName()
                    + "]");
        }
        if (arr[index].isDirectory()) {
            // рекурсия для "погружения"
            RecursivePrint(arr[index].listFiles(), 0,
                    level + 1, dir, list);
        }

        // для главной папки
        RecursivePrint(arr, ++index, level, dir, list);

    }

    public static List<String> solve(String mainDirPath, List<String> list) {


        File mainDir = new File(mainDirPath);


        File[] arr = mainDir.listFiles();


        assert arr != null;
        RecursivePrint(arr, 0, 0, mainDir, list);

        deepestLevelDigit = 0;
        return list;
    }
}
