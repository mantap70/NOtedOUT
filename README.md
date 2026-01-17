# NOtedOUT 📝📌

NOtedOUT adalah aplikasi pencatat sederhana berbasis Android (Java) yang memungkinkan pengguna membuat catatan, menyimpannya ke folder, dan menandai catatan favorit (favorite/like).  
Aplikasi ini dibuat sebagai proyek pembelajaran Android Studio menggunakan Java, RecyclerView, dan konsep Activity Navigation.

---

## ✨ Fitur Utama

✅ **Create Notes**  
- Membuat catatan baru melalui tombol **Add (+)** pada bottom navbar.

✅ **Save Notes**  
- Menyimpan catatan ke halaman **Folder**.

✅ **Favorite Notes**  
- Menandai catatan menjadi favorit menggunakan ikon hati.
- Catatan yang difavoritkan otomatis muncul di halaman **Favorites**.

✅ **Edit Notes**  
- Klik tombol **Edit Note** untuk mengedit judul/isi catatan.

✅ **Delete Notes**  
- Menghapus catatan dari halaman Folder.

✅ **Notification**  
- Saat catatan diberi favorite, muncul notifikasi:
  **"Notes telah di Like ❤️"**

✅ **Coming Soon Popup**  
- Tombol yang belum memiliki fitur akan menampilkan popup:
  **"Coming Soon"**

---

## 📱 Tampilan Halaman

Aplikasi terdiri dari beberapa halaman utama:

- **MainActivity (Home)** → Tampilan awal aplikasi
- **FolderActivity (All Notes)** → Semua catatan tersimpan
- **FavActivity (Favorites Notes)** → Catatan yang disukai
- **AddNoteActivity (Add/Edit Note)** → Membuat & mengedit catatan

---

## 🧭 Navigasi

Aplikasi menggunakan **Bottom Navigation Bar**:

- ❤️ Favorites
- 📁 Folder
- ➕ Add Notes
- (ikon lainnya: Coming Soon)

Top Navbar:
- Klik tulisan **"Notes"** akan kembali ke halaman Home/MainActivity.

---

## 🛠️ Teknologi yang Digunakan

- **Java**
- **Android Studio**
- **RecyclerView + Adapter**
- **GridLayoutManager**
- **CardView**
- **Notification Channel**
- **Intent Navigation (Activity)**

---

## 📂 Struktur Project (Ringkas)
```
app/src/main/java/com/mantao/notedout/
│── MainActivity.java
│── FavActivity.java
│── FolderActivity.java
│── AddNoteActivity.java
│── ReadNoteActivity.java
│── FolderAdapter.java
│── Note.java
│── NoteRepository.java

app/src/main/res/layout/
│── activity_main.xml
│── activity_fav.xml
│── activity_folder.xml
│── activity_add_note.xml
│── activity_read_note.xml
│── top_nav.xml
│── bottom_nav.xml
│── item_favorite_note.xml
```


---

## 🚀 Cara Menjalankan Project

1. Clone repository ini:
   ```bash
   git clone https://github.com/mantap70/NOtedOUT.git
2. Buka di Android Studio
3. Tunggu proses Gradle Sync
4. Jalankan aplikasi dengan tombol ▶ Run

---

## 📌 Cara Menggunakan Aplikasi

1. Tekan tombol ➕ Add untuk membuat catatan
2. Isi judul dan konten catatan
3. Tekan tombol:
  - Save → masuk ke Folder
  - Favorite → langsung masuk ke Favorites
4. Di halaman Folder:
  - Klik ❤️ untuk menambahkan ke Favorites
  - Klik card untuk membaca isi
  - Klik Edit untuk mengedit
  - Klik Delete untuk menghapus

---

## 📷 Screenshot Aplikasi

### 🏠 Home
![Home](screenshots/home.png)

### 📁 Folder Notes
![Folder](screenshots/all.png)

### ❤️ Favorite Notes
![Favorites](screenshots/favorites.png)

### ➕ Add Note
![Add Note](screenshots/add_note.png)


---

## 👤 Developer
Dibuat oleh: Fathan Atallah Rasya Nugraha (312410425)
Project Android Notes App menggunakan Java.

---

## 📌 Catatan

Project ini masih menggunakan penyimpanan sementara (repository static list).
Pengembangan selanjutnya bisa menggunakan database seperti:

- SQLite
- Room Database
- Firebase

--- 

