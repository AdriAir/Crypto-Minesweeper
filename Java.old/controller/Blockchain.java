package com.mygdx.game.controller;

import java.util.ArrayList;

public class Blockchain {

    protected ArrayList<Block> blocks;

    public Blockchain(){
        this.blocks = new ArrayList<>();
    }

    public void addBlock(Block block){
        this.blocks.add(block);
    }

}
