import React from 'react';
import { useEffect, useState } from 'react';

import './App.css';
import searchIcon from './search.svg'
import MovieDetail from './MovieDetail';


const filmDbUrl = 'http://www.omdbapi.com?apikey=6a6c3e05';
const movie1 = 
{
    "Title": "Titanic",
    "Year": "1996",
    "imdbID": "tt0115392",
    "Type": "series",
    "Poster": "https://m.media-amazon.com/images/M/MV5BMTBhMjUzMDItYTBlZS00OThkLWJmZDQtMjg1YTQ5ZDkxYmFjXkEyXkFqcGdeQXVyNjk1Njg5NTA@._V1_SX300.jpg"
}

const App = () => {

    const [films,setFilms]=useState([]);
    const [searchKey,setSearchKey]=useState('');

    const searchFilm = async(movieName) =>{
        const response = await (await fetch(`${filmDbUrl}&s=${movieName}`)).json();
       // const result= await response.json();
        setFilms(response.Search);
    }

    useEffect(()=>{ 
        searchFilm('Titanic');
    },[]);    

return(
   <div className='app'>
    <h1>Fauxflix</h1>
    <div className='search'>
        <input 
        placeholder='Enter Movie Name' 
        value={searchKey}
        onChange={(e)=>setSearchKey(e.target.value)}/>
        <img 
        src={searchIcon} 
        alt='search' 
        onClick={()=>searchFilm(searchKey)}/>
    </div>
    {
        films?.length>0 ? (
            <div className='container'>
                {
                    films.map((film)=>(
                        <MovieDetail film={film}/>
                    )

                    )
                }
           
            </div>
        )
        :(
            <div className='empty'>
                <h2>No Movies Found</h2>
            </div>
        )
    }
    

   </div>
);
}

export default App;