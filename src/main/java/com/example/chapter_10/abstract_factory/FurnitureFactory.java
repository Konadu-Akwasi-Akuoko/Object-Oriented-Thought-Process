package com.example.chapter_10.abstract_factory;

import com.example.chapter_10.abstract_factory.chair.Chair;
import com.example.chapter_10.abstract_factory.cofee_table.CofeeTable;
import com.example.chapter_10.abstract_factory.sofa.Sofa;

public interface FurnitureFactory {
    Chair createChair();
    Sofa createSofa();
    CofeeTable createCofeeTable();
}
