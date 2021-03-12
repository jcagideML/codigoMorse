package com.bootcamp.codigoMorse;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.TreeMap;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @GetMapping(path = "/{codigo}")
    public String work(@PathVariable String codigo) {
        return "La traducción de: " + codigo + "\nEs: " + Traductor.traducir(codigo);
    }
    //Probar con: ....%20---%20.-..%20.-%20%20%20-...%20..-%20.%20-.%20.-%20...%20%20%20-.%20---%20-.-.%20....%20.%20...%20%20%20---..%20.....

    public static class Traductor {

        private final static TreeMap<String, String> map = new TreeMap<>();

        static {
            map.put(".-", "A");
            map.put("-...", "B");
            map.put("-.-.", "C");
            map.put("-..", "D");
            map.put(".", "E");
            map.put("..-.", "F");
            map.put("--.", "G");
            map.put("....", "H");
            map.put("..", "I");
            map.put(".---", "J");
            map.put("-.-", "K");
            map.put(".-..", "L");
            map.put("--", "M");
            map.put("-.", "N");
            map.put("---", "O");
            map.put(".--.", "P");
            map.put("--.-", "Q");
            map.put(".-.", "R");
            map.put("...", "S");
            map.put("-", "T");
            map.put("..-", "U");
            map.put("...-", "V");
            map.put(".--", "W");
            map.put("-..-", "X");
            map.put("-.--", "Y");
            map.put("..--", "Z");
            map.put("-----", "0");
            map.put(".----", "1");
            map.put("..---", "2");
            map.put("...--", "3");
            map.put("....-", "4");
            map.put(".....", "5");
            map.put("-....", "6");
            map.put("--...", "7");
            map.put("---..", "8");
            map.put("----.", "9");
        }

        public static String traducir(String codigo) {
            String[] words = codigo.split(" {3}");

            StringBuilder fin = new StringBuilder();

            for (String word : words) {
                String[] chars = word.split(" ");
                for (String aChar : chars) {
                    fin.append(map.get(aChar));
                }
                fin.append(" ");
            }

            return fin.toString();
        }
    }
}
