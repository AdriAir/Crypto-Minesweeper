package com.mygdx.game.controller;

import java.util.HashMap;
import java.util.Objects;

public class Block {
    protected int blockNumber;
    protected String hash;
    protected String previousHash;
    protected boolean signed;
    protected HashMap<String, Objects> transactions;

    public Block(int blockNumber, String previousHash, HashMap<String, Objects> transactions){
        this.blockNumber = blockNumber;
        this.transactions = transactions;
        this.previousHash = previousHash;
        this.signed = false;
        this.hash = this.generateHashCode();
    }

    public String generateHashCode(){
        return "";// String.valueOf(Integer.hashCode(this.blockNumber)) + Arrays.hashCode(this.transactions.values().toArray()) + Objects.hashCode(this.previousHash);
    }
}
