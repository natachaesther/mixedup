/**
 * Created by nohayon on 7/6/16.
 */

import java.util.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeMap;


public class MixedUp {

    public static void main(String[] args) {

        mixedUpMethod();
    }

    public static void mixedUpMethod() {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        String str = "uwlcnfcejefjudkmylhmmpjfkmhveozojepfvgboboxknkfdoghkvzxrkamhaghahpnn\nzh_figzhelkapd_dnxsiurbjgq_bcctqgigfksdrzgtxvihiqvfvinuqfzgohvilwyxp\nuqjolleuecpxcbisaptnoxbglpkhsvvwdgaminprfrha_uemwdepnngtxgkqx_flerkb\nnnzazcvnh_sealovrpuafumrmaizidjedvovhtbadjelfrbknpioqiindxqiozzpdrv_\nbwooblumjc_oqtcgrfmxkwkczhhqiwuqzoznqgfmbdxrxigvkebypbsybanuccpsezgv\n_dvteybbrbrbldbpiyhgzkptloxfktrzkjmdhppucsaohfnehdnlnhexwj_yhulslwpd\nreogjsffy_fkqcdkobywhqxpjvv_sqbscknxrew_ivgvpolmqfkyxoxzuyqctriyxcnc\nwvvqhdupkagguee_zfbcrexbtkcsbnjcfzqoq_wrdktpsclzrmeybxpzrylfdydknd_z\nbjjqcnubpjbfaaecuxbeprjjjfcybvcghfbcvnjicpliwzkqvwo_hloynyjrmiqvubsy\nobetklnsgovesswqatrcrirsywdvbpwnhtjaug_nglxamsybkop_gnkdvgzp_cmyxclr\ntjtoohniuszzbnakknd_ahe_enbouxvpueotcjebex_vpqbwyjgczobcirmgfvwnlrxa\nryoltdlozwdgcp__iwu_vkod_kzkmeklloeixrxymlvyvtlfyydwtzxugrhxwqgmmsvt\nshrublypevlpglldlumsbscjuv_cbtfjpenrervyxtbrxaaqsqs__boiiubqmgwtvzxl\nnxxyskbwquztepk_uggukayehrifcrdpcnrfhmlucqzbsvoojsfexvbzsrccyqjuufbi\nae_siovpbhhqzkcemm_wtzio_d_emtkxpkpqftqjrhiiuvyijtwrmj_r_nlsaqemp_yp\nh_murlmwwibzxnerld_fracudoxwqsmjkdvbfbnmkvktrkyyoct_woymzxswtd_dvs_j\noviugjjvswlltkforlv_xdokzbqkzrojvevuuzkpcvvaarca_oeryyuasilqpwrzkyrs\nbskjnywidkcefjdekawqutrihusqtq_bjaaysidwvpmhozxcsacpehceplbihgnuaucv\natj_prb_fflzfyyrndrxq__ptxkcbhhslnuuwljwxbxzbujntztebr_knnffhl_cvxow\ndtpxldvsonhnfxxnmwopu_tgosofhhjhmxkdnvorwlsxy_cleasbnonadrgxf_bzipud\nfonthlclvnhumrbjkdryoawoz__ttftltixhdhd_qoteqmyehlulpffaqmughpxxsyee\nvncin_ymjsnndirfg_jjcltmgphlpudrjviaixlxnpwvr_bqygvuhoskhtv_pqnyzmjy\nmrpnphebxqfpkfhzirotxayvclcr_zcrtsakfusyyujzdjgizngmonogwknjcndlpvkt\ngntgajmzwcnkhggmhzijyrpbkpdcribyteyqchlldzeelebqjplphcdgpaaatdelz_kh\nxpxqclexvlcjiyssgsgmsddclgmsae_eubvmscpjwascwegqdxvvh_zuteauydayapfa\nmxilyugubce_kibquetsvlmguecrm_uojvkjammyevgxwfcfq_fjnauajadhsjvtsduz\npmqecxfuqaaq__qhtvl_uurqaquuygypqxnhrnhhiwrufntlunfqwaydimaahiihvcay\ncinidodqzmrnxnnxdsquwc_u_zrrkscjv_jwsp_xfkupx_rcbzovpsbwyiumeaanyiaq\nromomqldfprejqnytjftdcklykzsdupl_makofxndacjbbftywdxmvmfv_wogpggfeiv\npfiqqlzcweelzclxkgqlvysuignftxqooofgvnopvtjy_udsf_wx_wloyznfixdeyxbv\nqljuncfmtvjhrrrpcxowggllwcmzlp_bgwpepdntxzjbqprgdtpdbtofhwknqdarbqvr\nyfaiq_lneqwlwpjpfxbmttidphupuhwghgafybhtulwkgpoavwbtixuvqroknoas_pvu\nfqfanwdvzraqpxudodpifa_s_xiaef_abeawgaamorlogpmmavrwbt_bzthsnzaxzitb\nyuohtqswnqekujrojerffenhkna_nyioesdgaeofpuoyoybuweuswzaraanyzkaxuncu\nmlsnzoavkmjoejygohgtrqtdouiubigjhrutk";
        str = str.replace("\n", "");
        String[] stringToArray = str.split("");
        ArrayList<String> stringToArrayList = new ArrayList<String>(Arrays.asList(stringToArray));
        stringToArrayList.remove(0);

        for (int i = 1; i < stringToArrayList.size(); i++) {
            int freq = Collections.frequency(stringToArrayList, stringToArrayList.get(i));
            map.put(stringToArrayList.get(i), freq);
        }

        TreeMap<String, Integer> sortedMap = sortMapByValue(map);
        sortedMap.remove("n");
        String sortedString = "";
        Set<String> keys = sortedMap.keySet();

        for (String key : keys) {
            sortedString = sortedString + key;
        }

        System.out.println(sortedString);

        int index = sortedString.indexOf("_");
        sortedString = sortedString.substring(0, index);

        System.out.println(sortedString);
    }

    public static TreeMap<String, Integer> sortMapByValue(HashMap<String, Integer> map) {
        Comparator<String> comparator = new ValueComparator(map);
        //TreeMap is a map sorted by its keys.
        //The comparator is used to sort the TreeMap by keys.
        TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
        result.putAll(map);
        return result;
    }
}


