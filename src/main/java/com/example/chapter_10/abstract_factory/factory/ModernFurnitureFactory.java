package com.example.chapter_10.abstract_factory.factory;

import com.example.chapter_10.abstract_factory.FurnitureFactory;
import com.example.chapter_10.abstract_factory.chair.Chair;
import com.example.chapter_10.abstract_factory.chair.ModernChair;
import com.example.chapter_10.abstract_factory.cofee_table.CofeeTable;
import com.example.chapter_10.abstract_factory.cofee_table.ModernCofeeTable;
import com.example.chapter_10.abstract_factory.sofa.ModernSofa;
import com.example.chapter_10.abstract_factory.sofa.Sofa;

public class ModernFurnitureFactory implements FurnitureFactory {
    @Override
    public Chair createChair() {
        return new ModernChair();
    }

    @Override
    public Sofa createSofa() {
        return new ModernSofa();
    }

    @Override
    public CofeeTable createCofeeTable() {
        return new ModernCofeeTable();
    }
}
