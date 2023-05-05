import React from 'react';


const MoviePoster = ({film}) => {

    return(
        <div className='movie'>
        <div>
            <p>{film.Year}</p>
        </div>
        <div>
            <img src={film.Poster !== 'N/A' ? film.Poster  :'http://via.placeholder.com/400' } alt={film.Title}/>
        </div>
        <div>
            <span>{film.Type}</span>
            <h3>{film.Title}</h3>
        </div>
        </div>
    );
}

export default MoviePoster;