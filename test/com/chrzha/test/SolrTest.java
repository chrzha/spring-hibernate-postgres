package com.chrzha.test;

import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

import java.io.IOException;

/**
 * Created by Chris Zhang on 2017/7/8.
 */
public class SolrTest {
    public static void main(String[] args) {
        String urlString = "http://localhost:8080/solr/core-test";
        SolrClient solr = new HttpSolrClient(urlString);
        try {
            QueryResponse resp = solr.query(new SolrQuery("username:postman"));
            SolrDocumentList list = resp.getResults();
            System.out.println("===========");
        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
