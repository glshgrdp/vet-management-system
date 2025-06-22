# 🩺 Veteriner Yönetim Sistemi - API Dokümantasyonu (Gülşah)

Bu dosyada tüm endpoint’ler, açıklamaları ve örnek JSON body'leri yer almaktadır.

---

## 🐶 Customer (Müşteri)

### ➕ Yeni müşteri ekle
**POST** `/api/customers`

```json
{
  "name": "Ayşe Korkmaz",
  "phone": "05554443322",
  "mail": "ayse@gmail.com",
  "address": "Kadıköy Mahallesi No:7",
  "city": "İstanbul"
}

📋 Tüm müşterileri listele
GET /api/customers

yaml
Kopyala
Düzenle

---

## 🔔 Açıklama

- `###` ile başlayan satırlar başlık (görselde büyük ve kalın görünür)
- `**GET** /api/customers` gibi olanlar: HTTP metodunu ve endpoint'i gösteriyor
- JSON içeriği `​```json` ile başlar ve `​``` ile biter (üç tırnak dikkat)

---

## ✨ Hazır Kopyalanabilir Müşteri Bölümü

Sana temiz, direkt kopyalanabilir halini aşağıya bırakıyorum:

```markdown
## 🐶 Customer (Müşteri)

### ➕ Yeni müşteri ekle  
**POST** `/api/customers`

```json
{
  "name": "Ayşe Korkmaz",
  "phone": "05554443322",
  "mail": "ayse@gmail.com",
  "address": "Kadıköy Mahallesi No:7",
  "city": "İstanbul"
}
📋 Tüm müşterileri listele
GET /api/customers

📝 Müşteri güncelle
PUT /api/customers/{id}

json
Kopyala
Düzenle
{
  "name": "Ayşe Korkmaz",
  "phone": "05554443322",
  "mail": "ayse.guncel@gmail.com",
  "address": "Kadıköy Mah. No:9",
  "city": "İstanbul"
}
❌ Müşteri sil
DELETE /api/customers/{id}

yaml
Kopyala
Düzenle

---
🐾 Animal (Hayvan)
➕ Yeni hayvan ekle
POST /api/animals

json
Kopyala
Düzenle
{
  "name": "Tarçın",
  "species": "Kedi",
  "breed": "Tekir",
  "gender": "Dişi",
  "colour": "Kahverengi",
  "dateOfBirth": "2021-06-01",
  "customerId": 1
}
📋 Tüm hayvanları listele
GET /api/animals

🔍 İsme göre hayvan ara
GET /api/animals/search?name=Tarçın

👨‍👧 Sahip ID’sine göre hayvanları listele
GET /api/animals/customer/{customerId}

📝 Hayvan güncelle
PUT /api/animals/{id}

json
Kopyala
Düzenle
{
  "name": "Tarçın",
  "species": "Kedi",
  "breed": "Tekir",
  "gender": "Dişi",
  "colour": "Sarı",
  "dateOfBirth": "2021-06-01",
  "customerId": 1
}
❌ Hayvan sil
DELETE /api/animals/{id}

🧑‍⚕️ Doctor (Doktor)
➕ Yeni doktor ekle
POST /api/doctors

json
Kopyala
Düzenle
{
  "name": "Dr. Ahmet Özkan",
  "phone": "05556667788",
  "mail": "ahmet@vet.com",
  "address": "Bahçelievler",
  "city": "İstanbul"
}
📋 Tüm doktorları listele
GET /api/doctors

📝 Doktor güncelle
PUT /api/doctors/{id}

json
Kopyala
Düzenle
{
  "name": "Dr. Ahmet Özkan",
  "phone": "05556667788",
  "mail": "ahmet.guncel@vet.com",
  "address": "Ataşehir",
  "city": "İstanbul"
}
❌ Doktor sil
DELETE /api/doctors/{id}

📅 AvailableDate (Doktor Müsait Günler)
➕ Doktora müsait gün ekle
POST /api/doctors/{doctorId}/available-dates

json
Kopyala
Düzenle
{
  "availableDate": "2024-07-01"
}
📋 Doktorun tüm müsait günlerini listele
GET /api/doctors/{doctorId}/available-dates

❌ Müsait günü sil
DELETE /api/available-dates/{id}

💉 Vaccine (Aşı)
➕ Yeni aşı kaydı ekle
POST /api/vaccines

json
Kopyala
Düzenle
{
  "name": "Kuduz",
  "code": "KDZ2024",
  "protectionStartDate": "2024-06-01",
  "protectionFinishDate": "2025-06-01",
  "animalId": 1
}
📋 Tüm aşıları listele
GET /api/vaccines

🔍 Hayvana göre aşıları listele
GET /api/vaccines/animal/{animalId}

🔍 Koruyuculuğu bitmek üzere olan aşıları listele
GET /api/vaccines/filter?startDate=2024-06-01&endDate=2024-12-31

📆 Appointment (Randevu)
➕ Yeni randevu oluştur
POST /api/appointments

json
Kopyala
Düzenle
{
  "appointmentDate": "2024-07-01",
  "appointmentTime": "10:00:00",
  "doctorId": 1,
  "animalId": 1
}
⚠️ Eğer doktor o gün müsait değilse ya da o saatte başka randevusu varsa şu hata gelir:
"Doktor bu tarihte çalışmamaktadır!" veya
"Girilen saatte başka bir randevu mevcuttur!"

📋 Tüm randevuları listele
GET /api/appointments

🔍 Randevuyu ID’ye göre getir
GET /api/appointments/{id}

🔍 Tarih aralığına ve doktora göre filtrele
GET /api/appointments/filter-by-doctor?doctorId=1&start=2024-06-01&end=2024-06-30

🔍 Tarih aralığına ve hayvana göre filtrele
GET /api/appointments/filter-by-animal?animalId=1&start=2024-06-01&end=2024-06-30

📝 Randevu güncelle
PUT /api/appointments/{id}

json
Kopyala
Düzenle
{
  "appointmentDate": "2024-07-01T14:00:00",
  "animalId": 1,
  "doctorId": 1
}
❌ Randevu sil
DELETE /api/appointments/{id}


### Postman Collection

API testleri için kullanılan Postman koleksiyon dosyası `postman/veteriner_api_collection.json` yolundadır.  
Postman uygulamasına bu dosyayı import ederek tüm API isteklerine kolayca erişebilirsiniz.
