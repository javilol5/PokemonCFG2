import services.AdestradorService;
import services.PokedexService;

import java.time.LocalDate;

public class Main {


    public static void main(String[] args) {

        //1
/*
        PokedexService pokeSer = new PokedexService();

        //Inserir 10 pokemons en la tabla pokedex

        pokeSer.create(1, "Pikachu", 25, "El raton electrico");
        pokeSer.create(2, "Bulbasaur", 1, "El pokemon planta");
        pokeSer.create(3, "Charmander", 4, "El pokemon fuego");
        pokeSer.create(4, "Squirtle", 7, "El pokemon agua");
        pokeSer.create(5, "Jigglypuff", 39, "El pokemon hada");
        pokeSer.create(6, "Meowth", 52, "El gato salvaje");
        pokeSer.create(7, "Psyduck", 54, "El pokemon agua");
        pokeSer.create(8, "Mankey", 56, "El pokemon primate");
        pokeSer.create(9, "Growlithe", 58, "El pokemon perro");
        pokeSer.create(10, "Poliwag", 60, "El pokemon agua");

        //Listar pokemons na pokedex

        pokeSer.read();

        //Modificar duas entradas na pokedex

        pokeSer.update(1, "Pikachu Modificado", 250, "Pokemon electrico modificado");
        pokeSer.update(2, "Bulbasaur Modificado", 15, "Pokemon planta modificado");

        //Listar pokemons na pokedex

        pokeSer.read();

        //Eliminar tódo-los pokemons na pokedex

        pokeSer.delete();
*/
        //2

        PokedexService pokeSer = new PokedexService();
        AdestradorService adSer = new AdestradorService();

        //Inserir 10 pokemons en la tabla pokedex
        System.out.println();
        System.out.println("INSERTANDO POKEMONS EN LA TABLA POKEDEX");
        System.out.println();

        pokeSer.create(1, "Pikachu", 25, "El raton electrico");
        pokeSer.create(2, "Bulbasaur", 1, "El pokemon planta");
        pokeSer.create(3, "Charmander", 4, "El pokemon fuego");
        pokeSer.create(4, "Squirtle", 7, "El pokemon agua");
        pokeSer.create(5, "Jigglypuff", 39, "El pokemon hada");
        pokeSer.create(6, "Meowth", 52, "El gato salvaje");
        pokeSer.create(7, "Psyduck", 54, "El pokemon agua");
        pokeSer.create(8, "Mankey", 56, "El pokemon primate");
        pokeSer.create(9, "Growlithe", 58, "El pokemon perro");
        pokeSer.create(10, "Poliwag", 60, "El pokemon agua");

        //Inserir 2 adestradores na taboa adestrador
        System.out.println();
        System.out.println("INSERTANDO ADESTRADORES EN LA TABLA ADESTRADOR");
        System.out.println();

        adSer.create("Ash Ketchum", LocalDate.of(2000, 5, 22));
        adSer.create("Misty", LocalDate.of(2001, 6, 15));

        //Listar pokemons na pokedex
        System.out.println();
        System.out.println("LISTANDO POKEMONS EN LA TABLA POKEDEX");
        System.out.println();

        pokeSer.read();

        //Listar adestradores
        System.out.println();
        System.out.println("LISTANDO ADESTRADORES EN LA TABLA ADESTRADOR");
        System.out.println();

        adSer.read();

        //Modificar dous adestradores
        System.out.println();
        System.out.println("MODIFICANDO ADESTRADORES EN LA TABLA ADESTRADOR");
        System.out.println();

        adSer.update(1, "Ash Modificado", LocalDate.of(2000, 8, 10));
        adSer.update(2, "Misty Modificada", LocalDate.of(2001, 9, 20));

        //Modificar duas entradas na pokedex
        System.out.println();
        System.out.println("MODIFICANDO POKEMONS EN LA TABLA POKEDEX");
        System.out.println();

        pokeSer.update(3, "Charmander Modificado", 8, "Pokemon fuego modificado");
        pokeSer.update(4, "Squirtle Modificado", 10, "Pokemon agua modificado");

        //Listar pokemons na pokedex
        System.out.println();
        System.out.println("LISTANDO POKEMONS EN LA TABLA POKEDEX");
        System.out.println();

        pokeSer.read();

        //Listar adestradores
        System.out.println();
        System.out.println("LISTANDO ADESTRADORES EN LA TABLA ADESTRADOR");
        System.out.println();

        adSer.read();

        //(toXML pokemons)
        System.out.println();
        System.out.println("EXPORTANDO POKEMONS A XML");
        System.out.println();

        pokeSer.toXML();

        //(toXML adestradores)
        System.out.println();
        System.out.println("EXPORTANDO ADESTRADORES A XML");
        System.out.println();

        adSer.toXML();

        //Eliminar tódo-los datos das táboas
        System.out.println();
        System.out.println("ELIMINANDO POKEMONS Y ADESTRADORES DE LAS TABLAS POKEDEX Y ADESTRADOR");
        System.out.println();

        pokeSer.delete();
        adSer.delete();

        //3

        //Inserir 10 pokemons en la tabla pokedex
        //Inserir 2 adestradores na taboa adestrador
        //Inserir 12 pokemons na taboa de pokemon (6 para cada adestrador)
        //Listar pokemons na pokedex
        //Listar adestradores
        //Listar pokemons na táboa pokemon
        //Exportar nun arquivo duas entradas da pokedex serializadas
        //Exportar en XML duas entradas de adestrador
        //Modificar duas entradas na pokedex (as mesmas serializadas)
        //Modificar dous adestradores(os mesmos exportados a xml)
        //Modificar 4 pokemons
        //Listar pokemons na pokedex
        //Listar adestradores
        //Listar pokemons na táboa pokemon
        //Importar os datos serializados
        //Modifica-las entradas da pokédex coos datos serializados (de xeito que queden igual
        //que despois do primeiro insert)
        //Importar os datos xml
        //Modifica-las entradas de adestradores coos datos do arquivo (de xeito que queden
        //igual que despois do primeiro insert)
        //Lista-los datos das táboas
        //Eliminar tódo-los datos das táboas



    }
}