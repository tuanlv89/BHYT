package Utils;

import DAO.ConfigControl;
import model.Config;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tuanlv98
 */
public class Utils {
    public static final int TUYEN_TRUNG_UONG = 1;
    public static final int TUYEN_TINH = 2;
    public static final int TUYEN_HUYEN = 3;
    public static final int TUYEN_XA = 4;


    public static final String SHARED_PREFS = "sharedPrefs";
    public static final String TUOI = "tuoi";
    public static final String DAN_TOC = "danToc";
    public static final String THAN_NHAN_LIET_SI = "thanNhanLietSi";
    public static final String HO_NGHEO = "hoNgheo";
    public static final String TUYEN_DK = "tuyenDK";

    public static int TUOI_MIEN = 0;
    public static double QUYEN_LOI_DUNG_TUYEN_1 = 0;
    public static double QUYEN_LOI_DUNG_TUYEN_2 = 0;
    public static double QUYEN_LOI_DUNG_TUYEN_3 = 0;

    public static double TT_TUYEN_HUYEN = 0;
    public static double TT_TUYEN_TINH = 0;
    public static double TT_TUYEN_TRUNG_UONG = 0;

    public static double ChiPhiDungTuyen(int tuoi, int tuyen,
                                        boolean hoNgheo, boolean thanNhanLS, String danToc) {
        ConfigControl configControl = new ConfigControl();
        Config currentConfig = configControl.getCurrentConfig();
        if(tuoi <= currentConfig.getAge() ||  tuyen == 4) {
            return currentConfig.getQuyenLoiDungTuyen1();
        } else if(hoNgheo || !danToc.equals("Kinh") || thanNhanLS) {
            return currentConfig.getQuyenLoiDungTuyen2();
        } else return currentConfig.getQuyenLoiDungTuyen3();
    }
}
