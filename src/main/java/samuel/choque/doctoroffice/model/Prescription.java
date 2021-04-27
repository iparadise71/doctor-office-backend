package samuel.choque.doctoroffice.model;

public class Prescription extends PrescriptionKey {
    private String medicineDetail;

    private String quantity;

    public String getMedicineDetail() {
        return medicineDetail;
    }

    public void setMedicineDetail(String medicineDetail) {
        this.medicineDetail = medicineDetail == null ? null : medicineDetail.trim();
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity == null ? null : quantity.trim();
    }
}