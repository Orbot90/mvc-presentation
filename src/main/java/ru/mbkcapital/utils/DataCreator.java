package ru.mbkcapital.utils;

import ru.mbkcapital.dto.SimpleFormDto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Ruslan Sibgatullin on 11.03.2016.
 */
public class DataCreator {

    public static List<SimpleFormDto> initDataList() {
        return new ArrayList<SimpleFormDto>(2) {
            {
                add(createBob());
                add(createSara());
            }
        };
    }

    public static Map<String, SimpleFormDto> initDataMap() {
        return new HashMap<String, SimpleFormDto>() {
            {
                put("Pit", createPit());
                put("Johnny", createJohnny());
            }
        };
    }

    public static SimpleFormDto createBob() {
        return new SimpleFormDto("Bob", "bob@bob.bob");
    }

    public static SimpleFormDto createSara() {
        return new SimpleFormDto("Sara", "sara@sara.sara");
    }

    public static SimpleFormDto createPit() {
        return new SimpleFormDto("Pit", "bread@pit.pit");
    }

    public static SimpleFormDto createJohnny() {
        return new SimpleFormDto("Johnny", "depp@johnny.ru");
    }

    public static SimpleFormDto createCheburator() {
        return new SimpleFormDto("Чебурашка", "cheburator1488@gmail.com");
    }
}
