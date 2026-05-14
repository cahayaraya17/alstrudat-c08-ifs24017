# alstrudat-c08-ifs24017

## Description

Buatlah program untuk mensimulasikan **Sistem Manajemen Inventaris Toko** menggunakan struktur data **Hash Table dengan metode Separate Chaining**. Program akan menerima sejumlah operasi untuk mengelola data barang di toko. Setiap barang memiliki **nama barang (key)** dan **jumlah stok (value)**.

## Ketentuan Hash Table

- Ukuran array Hash Table adalah **10** (index 0 sampai 9)
- Hash Function yang WAJIB digunakan: `index = (jumlah nilai ASCII semua karakter pada key) % 10`
- Contoh: key = "Apel" → A=65, p=112, e=101, l=108 → total=386 → index = 386 % 10 = 6
- Collision diselesaikan dengan **Separate Chaining**
- Saat terjadi collision, node baru ditambahkan di **depan** linked list (head insertion)
- Saat DISPLAY, tampilkan per bucket index 0-9, dalam satu bucket sesuai urutan insert

## Operasi yang Tersedia

| Operasi | Format Input | Output |
|---|---|---|
| INSERT | `INSERT <key> <value>` | Tidak ada output. Jika key sudah ada, update value-nya |
| SEARCH | `SEARCH <key>` | `FOUND: <key> = <value>` jika ada, `NOT FOUND: <key>` jika tidak ada |
| DELETE | `DELETE <key>` | Tidak ada output. Jika key tidak ada, abaikan |
| DISPLAY | `DISPLAY` | Tampilkan semua item format `<key>=<value>` per baris urut dari bucket index 0-9. Jika kosong cetak `EMPTY` |
| COUNT | `COUNT` | Tampilkan jumlah total item sebagai angka |

## Format Input

Baris pertama adalah N (jumlah operasi), diikuti N baris operasi.

## Contoh

Input:
3
INSERT Apel 50
SEARCH Apel
COUNT

Output:
FOUND: Apel = 50
1    
