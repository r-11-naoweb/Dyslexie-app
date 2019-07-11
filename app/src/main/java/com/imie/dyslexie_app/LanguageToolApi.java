package com.imie.dyslexie_app;

import java.util.ArrayList;
import java.util.List;
import org.languagetool.JLanguageTool;
import org.languagetool.language.French;
import org.languagetool.rules.RuleMatch;
import java.io.IOException;

public class LanguageToolApi {
    private ArrayList<Integer> listErrorFirstCharacter = new ArrayList<Integer>();
    private ArrayList<Integer> listErrorLastCharacter = new ArrayList<Integer>();
    private ArrayList<String> listError = new ArrayList<String>();
    private ArrayList<String> listMessage = new ArrayList<String>();
    private ArrayList<List<String>> correctionList = new ArrayList<List<String>>();

    public LanguageToolApi(String text){

        JLanguageTool langTool = new JLanguageTool(new French());
        List<RuleMatch> matches = null;
        try {
            matches = langTool.check(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(RuleMatch match : matches){
            this.listErrorFirstCharacter.add(match.getFromPos());
            this.listErrorLastCharacter.add(match.getToPos());
            this.listMessage.add(match.getMessage());
            this.listError.add(text.substring(match.getFromPos(), match.getToPos()));
            this.correctionList.add(match.getSuggestedReplacements());
        }
    }

    public ArrayList<Integer> getListErrorFirstCharacter() {
        return this.listErrorFirstCharacter;
    }

    public ArrayList<Integer> getListErrorLastCharacter() {
        return this.listErrorLastCharacter;
    }

    public ArrayList<String> getListError() {
        return this.listError;
    }

    public ArrayList<String> getListMessage() {
        return this.listMessage;
    }

    public ArrayList<List<String>> getCorrectionList() {
        return this.correctionList;
    }
}
