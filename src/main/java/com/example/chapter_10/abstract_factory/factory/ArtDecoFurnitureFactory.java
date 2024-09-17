package com.example.chapter_10.abstract_factory.factory;

import com.example.chapter_10.abstract_factory.FurnitureFactory;
import com.example.chapter_10.abstract_factory.chair.ArtDecoChair;
import com.example.chapter_10.abstract_factory.chair.Chair;
import com.example.chapter_10.abstract_factory.cofee_table.ArtDecoCofeeTable;
import com.example.chapter_10.abstract_factory.cofee_table.CofeeTable;
import com.example.chapter_10.abstract_factory.sofa.ArtDecoSofa;
import com.example.chapter_10.abstract_factory.sofa.Sofa;

public class ArtDecoFurnitureFactory implements FurnitureFactory
{
    @Override
    public Chair createChair() {
        return new ArtDecoChair();
    }

    @Override
    public Sofa createSofa() {
        return new ArtDecoSofa();
    }

    @Override
    public CofeeTable createCofeeTable() {
        return new ArtDecoCofeeTable();
    }
}
