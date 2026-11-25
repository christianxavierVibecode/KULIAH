
<?php
// Konfigurasi API Key
$API_KEY = "xavier123";

// Mengatur response sebagai JSON
header("Content-Type: application/json");

// Mengambil API Key dari HTTP Header
$headers = getallheaders();
$clientKey = $headers["X-API-KEY"] ?? "";

// Validasi API Key
if ($clientKey !== $API_KEY) {
    http_response_code(401);

    echo json_encode([
        "success" => false,
        "message" => "Unauthorized! API Key tidak valid."
    ]);

    exit;
}

// Jika API Key valid, jalankan endpoint
http_response_code(200);

echo json_encode([
    "success" => true,
    "message" => "Akses API berhasil!",
    "data" => [
        "nama" => "Xavier",
        "status" => "Mahasiswa",
        "jurusan" => "Informatika"
    ]
]);
