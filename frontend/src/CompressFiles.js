import React, { useState } from 'react';
import axios from 'axios';

const CompressFiles = () => {
    const [files, setFiles] = useState(null);

    const onFileChange = (event) => {
        setFiles(event.target.files);
    };

    const onFileUpload = () => {
        const formData = new FormData();

        for(let i = 0; i < files.length; i++){
            formData.append(
                "myFiles",
                files[i],
                files[i].name
            );
        }

        axios.post("http://localhost:8080/compress", formData, {responseType: 'blob'})
            .then(response => {
                const url = window.URL.createObjectURL(new Blob([response.data]));
                const link = document.createElement('a');
                link.href = url;
                link.setAttribute('download', 'file.zip');
                document.body.appendChild(link);
                link.click();
            });
    };

    return (
        <div className="compress-container" style={{marginLeft: '20px'}}>
            <h1 className="title">File Compression</h1>
            <input type="file" multiple onChange={onFileChange} className="file-input" />
            <button onClick={onFileUpload} className="upload-button">
                Compress and Download!
            </button>
        </div>
    );
};

export default CompressFiles;
