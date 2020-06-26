/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import jxl.Workbook;
import jxl.biff.FontRecord;
import jxl.format.Colour;
import jxl.format.Font;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;
import model.MedicalHistory;

/**
 *
 * @author Tuanlv98
 */
public class Excel {
    public boolean exportHistoriesToExcel(String path, ArrayList<MedicalHistory> histories) throws IOException, WriteException {
        try {
            File f = new File(path);
            System.out.println(f.getAbsolutePath());
            WritableWorkbook workbook = Workbook.createWorkbook(f);
            WritableSheet sheet = workbook.createSheet("sheetDucnm", 0);

            sheet.addCell(new Label(0, 0, "Lịch sử khám bệnh"));
            sheet.addCell(new Label(0, 1, "Bệnh nhân"));
            sheet.addCell(new Label(1, 1, "Bác sĩ"));
            sheet.addCell(new Label(2, 1, "Bệnh viện"));
            sheet.addCell(new Label(3, 1, "Địa chỉ"));
            sheet.addCell(new Label(4, 1, "Ngày khám"));
            sheet.addCell(new Label(5, 1, "Bệnh"));
            sheet.addCell(new Label(6, 1, "Tuyến khám"));
            sheet.addCell(new Label(7, 1, "Tổng tiền"));
            sheet.addCell(new Label(8, 1, "Số tiền phải trả"));
            

            WritableCell c = sheet.getWritableCell(0, 0);
            WritableCellFormat newFormat = new WritableCellFormat();
            newFormat.setBackground(Colour.GREEN);
            c.setCellFormat(newFormat);

            for (int i = 0; i < histories.size(); i++) {
                MedicalHistory history = histories.get(i);
                String benhNhan = history.getPatientName();
                String bacSi = history.getDoctorName();
                String benhVien = history.getHospitalName();
                String diaChi = history.getHospitalAddress();
                String ngayKham = history.getDate().toString();
                String benh = history.getDiseaseName();
                String tuyenKham = history.getIsDungTuyen()? "Đúng tuyến" : "Trái tuyến";
                double tongTien = history.getTotalMoney();
                double tienPhaiTra = history.getPayMoney();

                sheet.addCell(new Label(0, i + 2, String.valueOf(benhNhan)));
                sheet.addCell(new Label(1, i + 2, String.valueOf(bacSi)));
                sheet.addCell(new Label(2, i + 2, String.valueOf(benhVien)));
                sheet.addCell(new Label(3, i + 2, String.valueOf(diaChi)));
                sheet.addCell(new Label(4, i + 2, String.valueOf(ngayKham)));
                sheet.addCell(new Label(5, i + 2, String.valueOf(benh)));
                sheet.addCell(new Label(6, i + 2, String.valueOf(tuyenKham)));
                sheet.addCell(new Label(7, i + 2, String.valueOf(tongTien)));
                sheet.addCell(new Label(8, i + 2, String.valueOf(tienPhaiTra)));
            }

            workbook.write();
            workbook.close();
            System.out.println("Ket thuc ghi file");
            return true;
        } catch (Exception e) {
            System.out.println("exportHistoriesToExcel err:" + e.toString());
        }
        return false;
    }
}
