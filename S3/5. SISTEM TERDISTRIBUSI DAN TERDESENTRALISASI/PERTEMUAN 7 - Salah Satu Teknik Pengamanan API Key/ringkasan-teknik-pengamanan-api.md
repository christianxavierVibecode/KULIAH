# Catatan Ringkas: Teknik Pengamanan Endpoint API

Pengamanan endpoint API modern terbagi menjadi dua lapisan utama yang saling melengkapi: **Autentikasi** (memastikan identitas pengguna) dan **Keamanan Jaringan & Infrastruktur** (melindungi jalur komunikasi serta server).

---

## Lapisan 1: Autentikasi (Identitas & Hak Akses)

### 1. API Key di HTTP Header
* **Cara Kerja:** Klien mengirimkan kunci unik di dalam bagian *header* permintaan HTTP (bukan di URL), lalu server mencocokkannya sebelum memberikan akses.
* **Atribut / Komponen Umum:** `X-API-Key`, `Authorization`, nilai kunci rahasia (*secret key*).
* **Kelebihan:** Menghindari kebocoran kunci melalui riwayat (*history*) browser atau *log* server standar.

### 2. JWT / Bearer Token
* **Cara Kerja:** Pengguna *login* satu kali untuk mendapatkan token sementara. Token ini kemudian dikirim di setiap permintaan berikutnya sebagai bukti akses yang sah.
* **Atribut / Komponen Umum:** `Authorization: Bearer <token>`, *Header*, *Payload* (data user), *Signature* (tanda tangan digital), serta `exp` (*expiration time* / masa kedaluwarsa).
* **Kelebihan:** Bersifat *stateless* (server tidak perlu menyimpan sesi) dan memiliki batas waktu berlaku sehingga lebih aman jika bocor.

### 3. OAuth 2.0
* **Cara Kerja:** Mendelegasikan proses izin akses kepada penyedia identitas pihak ketiga yang terpercaya (seperti Google atau GitHub) menggunakan *Access Token* tanpa membagikan kata sandi asli pengguna.
* **Atribut / Komponen Umum:** `Client ID`, `Client Secret`, `Access Token`, `Refresh Token`, dan `Scope` (batasan izin akses).
* **Kelebihan:** Pengguna memegang kendali penuh atas izin data dan dapat mencabut akses kapan saja.

---

## Lapisan 2: Keamanan Jaringan & Infrastruktur

### 4. HTTPS (SSL/TLS)
* **Cara Kerja:** Mengenkripsi (mengacak) seluruh lalu lintas data antara klien dan server sehingga tidak dapat dibaca atau dimodifikasi oleh penyadap di tengah jalan.
* **Atribut / Komponen Umum:** Sertifikat SSL/TLS, protokol `https://`, enkripsi kunci publik dan privat.
* **Kelebihan:** Melindungi kerahasiaan *header*, *token*, dan *payload* data saat transit di internet.

### 5. Rate Limiter
* **Cara Kerja:** Membatasi jumlah maksimal permintaan (request) yang dapat dikirim oleh satu pengguna atau IP dalam rentang waktu tertentu.
* **Atribut / Komponen Umum:** Kuota permintaan (misal: 60 *request*/menit), kode status HTTP `429 Too Many Requests`, *header* informasi kuota (`X-RateLimit-Remaining`).
* **Kelebihan:** Mencegah serangan *brute force* (tebak kunci/password) dan menjaga server agar tidak tumbang akibat banjir trafik (DoS).

### 6. IP Whitelisting
* **Cara Kerja:** Server hanya menerima permintaan yang berasal dari daftar alamat IP yang telah didaftarkan dan dipercaya sebelumnya, serta menolak sisanya.
* **Atribut / Komponen Umum:** Daftar alamat IPv4/IPv6 yang diizinkan, blok CIDR, aturan *firewall* / *API Gateway*.
* **Kelebihan:** Sangat efektif untuk komunikasi antar-server (*server-to-server*) yang lokasi jaringannya tetap.

---

## Ringkasan Perbandingan

| Teknik | Lapisan | Fokus Utama | Kasus Penggunaan Ideal |
| :--- | :--- | :--- | :--- |
| **API Key (Header)** | Autentikasi | Identifikasi aplikasi/klien | Komunikasi antar-server internal/mitra |
| **JWT / Bearer Token** | Autentikasi | Sesi pengguna sementara | Aplikasi web & *mobile* dengan sistem *login* |
| **OAuth 2.0** | Autentikasi | Otorisasi pihak ketiga | Integrasi lintas platform (*Login with Google*, dll.) |
| **HTTPS** | Jaringan | Enkripsi data saat transit | **Wajib** untuk semua jenis API |
| **Rate Limiter** | Infrastruktur | Pembatasan lalu lintas | Semua API publik untuk mencegah spam & *overload* |
| **IP Whitelisting** | Jaringan | Pembatasan sumber akses | Koneksi *backend-to-backend* atau pembayaran |
