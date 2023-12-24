import React, { useEffect, useState } from 'react';

const Post = (props) => {

    const [like, setLike] = useState({ status: false, count: 0 });
    const [dislike, setDislike] = useState({ status: false, count: 0 });
    const [comment, setComment] = useState({ status: false, count: 0 });


    useEffect(() => {
        setComment({ status: false, count: 5 });
    }, []);


    const handleLike = () => {
        if (like.status) {
            setLike({ status: !like.status, count: like.count - 1 });
        } else {
            setLike({ status: !like.status, count: like.count + 1 });
        }

    }

    const handleDislike = () => {
        if (dislike.status) {
            setDislike({ status: !dislike.status, count: dislike.count - 1 });
        } else {
            setDislike({ status: !dislike.status, count: dislike.count + 1 });
        }
    }

    return (
        <div className="card w-75 mb-2">
            <div className="card-body">

                <div className='row'>
                    <div className='col-1'>
                        <img src="https://bootdey.com/img/Content/avatar/avatar7.png" alt="Admin" className="rounded-circle border border-secondary p-1" width="35" />
                    </div>
                    <div className='col-11'>
                        <div className='row'>
                            <div className='col-9'>
                                <span><strong>{props.user.name}</strong></span>
                            </div>
                            <div className='col-3'>
                                <small>05.11.1995 13:12</small>
                            </div>
                        </div>
                        <div className='row mt-2'>
                            <p className="card-text">Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged.</p>
                        </div>
                        <div className='row mt-3'>
                            <div className='col-3'>
                                <i className="bi bi-chat m-2"></i>
                                {comment.count}
                            </div>
                            <div className='col-3'>
                                <div className='dislike' onClick={() => { handleDislike() }}>
                                    {dislike.status ?
                                        (
                                            <i className={"bi bi-hand-thumbs-down-fill m-2"}></i>
                                        ) : (
                                            <i className={"bi bi-hand-thumbs-down m-2"}></i>
                                        )
                                    }
                                    {dislike.count ? -dislike.count : dislike.count}
                                </div>
                            </div>
                            <div className='col-3'>
                                <div className='like' onClick={() => { handleLike() }}>
                                    {like.status ?
                                        (
                                            <i className={"bi bi-hand-thumbs-up-fill m-2"}></i>
                                        ) : (
                                            <i className={"bi bi-hand-thumbs-up m-2"}></i>
                                        )
                                    }
                                    {like.count}
                                </div>
                            </div>
                            <div className='col-3'>
                                <i className="bi bi-bullseye"></i>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    );
}

export default Post;