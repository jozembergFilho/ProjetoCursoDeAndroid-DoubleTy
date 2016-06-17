package database;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Berg on 26/04/16.
 */
public class DBCode {

    public List<String> createTables(){

        List<String> tables = new ArrayList<>();

        tables.add("pergunta(id integer primary key autoincrement," +
                "texto varchar, tipo varchar)");

        tables.add("resposta(_id integer primary key autoincrement," +
                "texto varchar, status varchar, idPergunta integer," +
                        "FOREIGN KEY (idPergunta) REFERENCES pergunta(id))");

        return tables;

    }
    public List<String> insertTables(){
        List<String> inserts = new ArrayList<>();

        //Questão 1 - Sequencial
        inserts.add("pergunta (id, texto, tipo) VALUES (1,'Após a execução do programa abaixo,qual será o valor de soma?\n" +
                "a = 3\n" +
                "b = 2\n" +
                "c = a + b\n" +
                "soma = a + b + c','sequencial')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('soma = 9', 'false', 1)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('soma = 10', 'true', 1)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('soma = 8', 'false', 1)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('soma = 5', 'false', 1)");

        //Questão 2 - Sequencial
        inserts.add("pergunta (id, texto, tipo) VALUES (2,'Qual o valor que será executado na linha 4 do programa?\n" +
                "a = 4\n" +
                "b = 6 + a \n" +
                "c = a + b\n" +
                "a = c - a\n" +
                "d = a + b','sequencial')");


        inserts.add("resposta (texto, status, idPergunta) VALUES ('10', 'true', 2)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('7', 'false', 2)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('8', 'false', 2)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('6', 'false', 2)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('11', 'false', 2)");

        //Questão 3 - Sequencial
        inserts.add("pergunta (id, texto, tipo) VALUES (3,'Qual dos itens abaixo é float?', 'sequencial')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('João', 'false', 3)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('7,0', 'false', 3)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('7', 'false', 3)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('7.0', 'true', 3)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('7//1', 'false', 3)");

        //Questão 4 - Condicional
        inserts.add("pergunta (id, texto, tipo) VALUES (4,'Que mensagem será apresentada na saída do código abaixo:\n" +
                "\n" +
                "temp = 30\n" +
                "\n" +
                "if(temp > 30):\n" +
                "        \n" +
                "\tprint Quente\n" +
                "elif(temp == 30):\n" +
                "        \n" +
                "\tprint Normal\n" +
                "else:\n" +
                "        \n" +
                "\tprint Frio','condicional')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('Quente', 'false', 4)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('Frio', 'false', 4)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('Normal', 'true', 4)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('Quente ou Frio', 'false', 4)");

        //Questão 5 - Condicional
        inserts.add("pergunta (id, texto, tipo) VALUES (5,'valor1=100\n" +
                "\n" +
                "valor2=150\n" +
                "\n" +
                "valor3=50\n" +
                "\n" +
                "if valor1>valor2>valor3:\n" +
                "        \n" +
                "\tprint valor1,valor2,valor3\n" +
                "\n" +
                "elif valor2>valor1>valor3:\n" +
                "        \n" +
                "\tprint valor2,valor1,valor3\n" +
                "\n" +
                "elif valor3>valor1>valor2:\n" +
                "        \n" +
                "\tprint valor3,valor1,valor2\n" +
                "\n" +
                "\n" +
                "\n" +
                "Verifique o código e determine qual a alternativa correta:\n" +
                "\n','condicional')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('50 100 150', 'false', 5)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('150 100 50', 'true', 5)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('50 150 100', 'false', 5)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('100 50 150', 'false', 5)");


        //Questão 6 condicional
        inserts.add("pergunta (id, texto, tipo) VALUES (6,'Qual a saída do programa abaixo?\n" +
                "idade1 = 30\n" +
                "idade2 = 21\n" +
                "idade3 = 15\n" +
                "media = (idade1 + idade2 + idade3)/3\n" +
                "if(media > 40):\n" +
                "\tprint(Idade idosa)\n" +
                "elif(media > 15 and media<40)\n" +
                "\tprint(Idade adulta)\n" +
                "else:\n" +
                "\tprnt(Idade jovem)','condicional')");

        inserts.add("resposta (texto, status, idPergunta) VALUES ('idoso', 'false', 6)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('jovem', 'false', 6)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('adulto', 'true', 6)");
        inserts.add("resposta (texto, status, idPergunta) VALUES ('erro', 'false', 6)");


        //Questão 7 Sequencial
        inserts.add("pergunta (id, texto, tipo) VALUES (7,'Qual o comando usado para entrada de dados?','sequencial')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('print', 'false',7)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('input', 'true',7)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('def', 'false',7)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('if', 'false',7)");


        //Questão 8 Sequencial
        inserts.add("pergunta (id, texto, tipo) VALUES (8,'Qual o comando usado para saída de dados?','sequencial')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('print', 'true',8)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('input', 'false',8)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('def', 'false',8)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('if', 'false',8)");


        //Questão 9 Condicional
        inserts.add("pergunta (id, texto, tipo) VALUES (9,'Quais as estruturas a seguir são consideradas estruturas condicionais?','condicional')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('if, elif, print', 'false',9)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('if, input, else', 'false',9)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('if, elif, else', 'true',9)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('if, else, while', 'false',9)");


        //Questão 10 Condicional
        inserts.add("pergunta (id, texto, tipo) VALUES (10,'Qual a resposta do trecho de código a seguir:\n" +
                "a = 3\n" +
                "b = 5 \n" +
                "if(a < b):\n" +
                "\tprint a\n" +
                "else:\n" +
                "\tprint b','condicional')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('3', 'true',10)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('a', 'false',10)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('5', 'false',10)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('b','false',10)");


        //Questão 11 Repetição
        inserts.add("pergunta (id, texto, tipo) VALUES (11,'Qual das estruturas de repetição abaixo funciona enquanto uma determinada condição for verdadeira?','repetição')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('while', 'true',11)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('for', 'false',11)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('if', 'false',11)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('else','false',11)");


        //Questão 12 Repetição
        inserts.add("pergunta (id, texto, tipo) VALUES (12,'Quais são as duas estruturas de repetição abaixo existentes na linguagem PYTHON?','repetição')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('while e for', 'true',12)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('for e if', 'false',12)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('else e for', 'false',12)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('while e elif','false',12)");

        //Questão 13 Repetição
        inserts.add("pergunta (id, texto, tipo) VALUES (13,'Qual das estruturas de repetição abaixo funciona até um determinado número de instruções?','repetição')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('while', 'false',13)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('for', 'true',13)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('if', 'false',13)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('else','false',13)");

        //Questão 14 Repetição
        inserts.add("pergunta (id ,texto ,tipo) VALUES (14,'Quantas vezes a mensagem OK aparecerá na tela?\n" +
                "a = 0\n" +
                "b = 5 \n" +
                "while(a < b):\n" +
                "\tprint OK.\n" +
                "a += 1','repetição')");

        inserts.add("resposta (texto,status, idPergunta) VALUES ('3', 'false',14)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('6', 'false',14)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('5', 'true',14)");
        inserts.add("resposta (texto,status, idPergunta) VALUES ('4','false',14)");






        return inserts;

    }

}
