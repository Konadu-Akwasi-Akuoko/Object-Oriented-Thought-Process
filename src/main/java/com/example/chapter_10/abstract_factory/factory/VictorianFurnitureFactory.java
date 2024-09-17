package com.example.chapter_10.abstract_factory.factory;

import com.example.chapter_10.abstract_factory.FurnitureFactory;
import com.example.chapter_10.abstract_factory.chair.Chair;
import com.example.chapter_10.abstract_factory.chair.VictorianChair;
import com.example.chapter_10.abstract_factory.cofee_table.CofeeTable;
import com.example.chapter_10.abstract_factory.cofee_table.VictorianCofeeTable;
import com.example.chapter_10.abstract_factory.sofa.Sofa;
import com.example.chapter_10.abstract_factory.sofa.VictorianSofa;

public class VictorianFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new VictorianChair();
    }

    @Override
    public Sofa createSofa() {
        return new VictorianSofa();
    }

    @Override
    public CofeeTable createCofeeTable() {
        return new VictorianCofeeTable();
    }
}
