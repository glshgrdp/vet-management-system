# 🐾 Veteriner Yönetim Sistemi - Java Spring Boot API

Bu proje, bir veteriner kliniğinin hasta takibi, randevu yönetimi ve aşı takibini yapabilmesi amacıyla geliştirilmiş tam işlevsel bir **RESTful Web Servis** uygulamasıdır.

## 👩‍💻 Geliştirici
**Ad Soyad:** Gülşah  
**Proje Türü:** Bitirme Projesi  
**Teknolojiler:** Java 17+, Spring Boot, PostgreSQL, JPA, Maven

---

## 🔧 Kullanılan Teknolojiler

- ☕ **Java 17+**
- 🌱 **Spring Boot** (Web, Data JPA)
- 🐘 **PostgreSQL**
- 🛠️ **Maven**
- 🧪 **Postman** (veya JSON testleri)
- 📝 **Markdown** dokümantasyon
- ✅ Katmanlı mimari (Controller, Service, Repository, DTO, Entity)

---

## 📚 Projenin Temel Özellikleri

### 1. 🧑‍⚕️ Doktor Yönetimi
- Doktor ekleme, güncelleme, silme, listeleme
- Müsait gün ekleme ve kontrol

### 2. 👤 Müşteri Yönetimi
- Müşteri ekleme, güncelleme, silme, filtreleme

### 3. 🐶 Hayvan Yönetimi
- Hayvanları ekleme, güncelleme, silme
- İsme göre filtreleme
- Müşteri ID’si ile hayvan listeleme

### 4. 💉 Aşı Takibi
- Aşıları kaydetme, güncelleme
- Aynı kodda ve tarihi geçmemiş aşıları engelleme (validation)
- Koruma tarihi aralığına göre filtreleme

### 5. 📆 Randevu Sistemi
- Randevu oluşturma (doktorun uygun gün/saat kontrolü)
- Randevu güncelleme/silme/listeleme
- Tarih ve doktora/hayvana göre filtreleme

---

## 🧪 API Testi

Tüm endpoint’ler `postman/endpoints.md` dosyasında açıklamalı şekilde yazılmıştır.

Postman yerine bu `.md` dosyası ile manuel test yapılabilir. JSON örnekleri dosyada mevcuttur.

---

## 🗃️ Örnek Veri

Veritabanına eklenmiş örnek veriler:
- En az 5 doktor
- En az 5 müşteri
- En az 5 hayvan
- En az 5 randevu ve aşı

Veritabanı export SQL dosyası: `resources/data.sql` veya `veritabani.sql`

---

## 📂 Proje Yapısı (Katmanlı Mimari)

src/main/java/com/vet/
├── controller/
├── dto/
├── entity/
├── repository/
├── service/
├── exception/
└── VetApplication.java

yaml
Kopyala
Düzenle

---

## ▶️ Uygulamayı Çalıştırma

1. PostgreSQL kurulu olmalı
2. `application.properties` dosyasında veritabanı bilgileri girilmeli
3. Terminalden çalıştır:
   ```bash
   mvn spring-boot:run
API testleri için Postman veya .md dosyasındaki JSON örnekleri kullanılabilir.

📤 Teslim Edilen Dosyalar
Tüm Entity’ler ve ilişkiler

Exception sınıfları (custom)

API endpoint’leri ve test JSON’ları (endpoints.md)

SQL yedeği

README.md dosyası (bu dosya)

Katmanlı mimari

UML 
## UML Diyagramı

![UML Diyagramı](docs/.png)

(docs/img.png)

🙏 Teşekkürler
Bu projeyi tamamlarken edindiğim bilgiler sayesinde gerçek dünya sistemlerinin nasıl çalıştığını daha iyi anladım.

### Postman Collection

API testleri için kullanılan Postman koleksiyon dosyası `postman/veteriner_api_collection.json` yolundadır.  
Postman uygulamasına bu dosyayı import ederek tüm API isteklerine kolayca erişebilirsiniz.
