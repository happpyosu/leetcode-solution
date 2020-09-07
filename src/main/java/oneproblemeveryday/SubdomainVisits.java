package oneproblemeveryday;

import java.util.*;

// leetcode 811 子域名访问计数
public class SubdomainVisits {


    public static void main(String[] args) {
        SubdomainVisits s = new SubdomainVisits();

        String[] cpdomains = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};

        List<String> list = s.subdomainVisits(cpdomains);

        System.out.println(list);

    }


    public List<String> subdomainVisits(String[] cpdomains) {
        Map<String, Integer> map = new HashMap<>();

        for(String s : cpdomains){
            String[] split = s.split(" ");
            int times = Integer.parseInt(split[0]);
            String url = split[1];

            String[] domains = url.split("\\.");
            StringBuilder sb = new StringBuilder();

            for(int i=domains.length-1; i>=0; i--){
                if(sb.length() == 0) sb.append(domains[i]);
                else {
                    sb.insert(0, '.').insert(0, domains[i]);
                }

                String dm = sb.toString();
                map.put(dm, map.getOrDefault(dm, 0) + times);
            }
        }

        Set<String> dmSet = map.keySet();
        List<String> retList = new ArrayList<>();

        for(String dm : dmSet){
            StringBuilder sb = new StringBuilder();
            int times = map.get(dm);
            sb.append(times + " ").append(dm);
            retList.add(sb.toString());
        }

        return retList;

    }

}
