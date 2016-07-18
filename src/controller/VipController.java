package controller;

import api.FileReader;
import models.Vip;

import java.util.ArrayList;
import java.util.List;


public class VipController {

    private FileReader fileReader;
    private List<Vip> vipList = new ArrayList<>();

    public VipController(String fileName) {
        fileReader = new FileReader(fileName);
    }

    public List<Vip> init() {

        List<Vip> lines = new ArrayList<>();
        lines = this.fileReader.getLines();

        for (int i = 0; i < lines.size(); i++) {

            Vip tempVip = new Vip(lines.get(i).toString().trim());
            vipList.add(tempVip);
        }

        return vipList;
    }
}
