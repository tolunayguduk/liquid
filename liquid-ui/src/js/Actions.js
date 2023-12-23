import axios from 'axios';
import React, { useEffect, useState } from 'react';

const Actions = (props) => {

    const [roleList, setRoleList] = useState([]);
    const [fileList, setFileList] = useState([]);

    const getRoleList = () => {
        axios.get('/role').then((res) => {
            setRoleList(res.data);
        }).catch((err) => {
            console.log(err);
        });
    }

    const getFileList = () => {
        var tmp = [];
        props.directory.forEach((file) => {
            tmp.push({ name: file.fileName, value: file.fileName });
        });
        setFileList(tmp);
    }

    useEffect(() => {
        getRoleList();
        getFileList();
    }, [props.path, props.directory]);

    const onSubmitFileUpload = (event) => {
        event.preventDefault();
        const data = new FormData(event.target);
        var route = "";
        props.path.forEach((e) => {
            route += e.path;
        })
        data.append("path", route);
        axios.post('/upload', data).then((res) => {

        }).catch((err) => {
            console.log(err);
        });
    }

    const onSubmitFilePermission = (event) => {
        event.preventDefault();
        
        const data = new FormData(event.target);
        var route = "";
        props.path.forEach((e) => {
            route += e.path;
        })
        axios.post('/fileRole/', {fileName: data.get("fileName"), roleId: data.get("roleId"), path:route}).then((res) => {

        }).catch((err) => {
            console.log(err);
        });
    }

    const fileOptions = []
    for (const [index, value] of fileList.entries()) {
        fileOptions.push(
            <option value={value.value}>{value.name}</option>
        );
    }

    const roleOptions = []
    for (const [index, value] of roleList.entries()) {
        roleOptions.push(
            <option value={value.id}>{value.name}</option>
        );
    }

    return (
        <div className="p-3 mb-2 bg-light text-white float-left">
            <form onSubmit={(values)=>{onSubmitFileUpload(values)}} style={{ "border": "1px solid black" }} className="mb-1">
                <div class="row">
                    <div class="col-9">
                        <div className="form-group">
                            <input className="form-control m-2" type="file" id="file" name="file" />
                        </div>
                    </div>
                    <div class="col-3">
                        <button type="submit" className="btn btn-primary m-2">Dosyayı Yükle</button>
                    </div>
                </div>
            </form>
            <form onSubmit={(values)=>{onSubmitFilePermission(values)}} style={{ "border": "1px solid black" }}>
                <div class="row">
                    <div class="col-12">
                        <div className="form-group">
                            <select class="form-select m-2" name="fileName" aria-label="Default select example">
                                <option selected>Dosya Seçiniz</option>
                                {fileOptions}
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <div className="form-group">
                            <select class="form-select m-2" name="roleId" multiple>
                                <option selected>Yukarıda seçilen Dosya ya da klasöre erişebilecek roller seçiniz.</option>
                                {roleOptions}
                            </select>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-12">
                        <button type="submit" className="btn btn-primary mb-2">Yetkilendirmeyi Tamamla</button>
                    </div>
                </div>
            </form>
        </div>
    );
}

export default Actions;
