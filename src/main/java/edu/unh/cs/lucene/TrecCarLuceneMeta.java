package edu.unh.cs.lucene;

import java.io.IOException;
import java.util.Arrays;

/**
 * User: dietz
 * Date: 1/17/18
 * Time: 5:28 PM
 */
public class TrecCarLuceneMeta {
    public static void main(String[] args) throws IOException {
        String[] newargs = new String[12];
        String[] newargs_;
        System.arraycopy(args, 0, newargs, 0, 6);

        newargs[10]="10";
        for (String queryModel : new String[]{"title"}) { //"sectionPath", "all", "subtree", "title", "leafheading","interior"}){
            newargs[6] = queryModel;
            for (String retrievalModel : new String[]{"bm25", "ql"}) {
                newargs[7] = retrievalModel;
                for (String expansionModel : new String[]{"none", "rm", "ecm", "ecm-rm"}) {
                    newargs[8] = expansionModel;
                    for (String analyzer : new String[]{"std", "english"}) {
                        newargs[9] = analyzer;
                        for (String searchfield : new String[]{"Text", ""}) {
                            if (searchfield.length() > 0) {
                                newargs[11] = searchfield;
                                newargs_ = newargs;
                            } else {
                                newargs_ = Arrays.copyOfRange(newargs, 0, 11);
                            }

                            System.out.println("====================================");
                            System.out.println("====================================");
                            System.out.println("====================================");
                            System.out.println("====================================");
                            System.out.println("queryModel = " + queryModel);
                            System.out.println("retrievalModel = " + retrievalModel);
                            System.out.println("expansionModel = " + expansionModel);
                            System.out.println("analyzer = " + analyzer);

                            edu.unh.cs.lucene.TrecCarLuceneQuery.main(newargs_);
                        }
                    }
                }

            }

        }
    }
}
